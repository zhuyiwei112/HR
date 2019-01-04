package com.hr.controller;

import com.hr.model.Account;
import com.hr.model.DeliverRes;
import com.hr.model.Recruit;
import com.hr.model.Resume;
import com.hr.service.DeliverResService;
import com.hr.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DeliverResController {
    @Resource
    private DeliverResService deliverResService;
    @Resource
    private ResumeService resumeService;

    @RequestMapping("cancelDR")
    public void cancelDR(Integer rid,HttpServletResponse response) throws Exception{
        PrintWriter pw=response.getWriter();
        DeliverRes deliver = deliverResService.getDResByRid(rid);
        deliver.setTime("");
        if (deliverResService.updateDRes(deliver)){
            pw.print("取消成功");
        }else {
            pw.print("取消失败");
        }
    }

    @RequestMapping("sendDR")
    public void sendDR(HttpSession session,Integer idDR,HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        List<DeliverRes> delivers = (List<DeliverRes>) session.getAttribute("delivers");
        Date date = new Date();
        String time = new SimpleDateFormat("yyy-MM-dd").format(date);
        if (delivers!=null||delivers.size()!=0){
            for (DeliverRes deliver : delivers) {
                if (idDR==deliver.getId()){
                    deliver.setTime(time);
                    deliver.setIsRead(1);
                    if (deliverResService.updateDRes(deliver)){
                        pw.print("发送成功");
                    }else {
                        pw.print("发布失败");
                    }
                }
            }
        }

    }

    @RequestMapping("updateDR")
    public void updateDR(Integer idDR,HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        DeliverRes deliver = new DeliverRes();
        deliver.setId(idDR);
        deliver.setIsRead(1);
        if (deliverResService.updateDRes(deliver)){

        }else {
            pw.print("隐藏失败");
        }
    }

    @RequestMapping("getDRes")
    public String getDRes(HttpSession session,String type,HttpServletResponse response) throws Exception{
        PrintWriter pw=response.getWriter();
        Account user = (Account) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        if ("employee".equals(user.getType())){
            pw.print("<script>alert(\"已是正式员工\");location.href='visgorcinfo'</script>");
            return null;
        }
        //System.out.println(delivers);
        if ("admin".equals(type)) {
            List<DeliverRes> delivers = deliverResService.getAllDres();
            session.setAttribute("delivers",delivers);
            return "admin/getdresinfo";
        }
        if ("visitor".equals(type)){
            DeliverRes deliverRes = deliverResService.getDResByRid(user.getResume().getId());
            session.setAttribute("deliver",deliverRes);
            return "visitor/offer";
        }
        return null;
    }

    @RequestMapping("addDRes")
    public void addDRes(HttpSession session, Integer idRC, HttpServletResponse response) throws Exception{
        PrintWriter pw=response.getWriter();
        Account user = (Account) session.getAttribute("user");
        if (user==null){
            pw.print("请先登入");
            return;
        }
        if ("employee".equals(user.getType())){
            pw.print("已是公司员工");
            return;
        }
        Account account=new Account();
        account.setId(user.getId());
        Resume resume = new Resume(account);
        //System.out.println(resume.getAccount());
        Resume resume1 = resumeService.getRS(resume);
        DeliverRes deliverRes=new DeliverRes();
        deliverRes.setIsRead(0);//未读
        deliverRes.setRecruit(new Recruit(idRC));
        deliverRes.setResume(resume1);
        deliverRes.setTime("");
        if (deliverRes.getResume()==null){
            pw.print("请先填写简历");
            return;
        }
        //System.out.println("resume："+resume1);
        //System.out.println("recruit："+deliverRes.getRecruit());

        int i = deliverResService.addDRes(deliverRes);
        switch (i){
            case 0:
                pw.print("您已在本公司投递过简历");
                break;
            case 1:
                pw.print("投递成功");
                break;
            case 2:
                pw.print("投递失败");
                break;
        }

    }
}
