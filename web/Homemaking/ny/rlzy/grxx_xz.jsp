<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
    <!--
    .STYLE1 {
        font-size: 24px;
        font-weight: bold;
    }
    -->
</style>
<head>
    <title>Untitled Document</title>
    <script type="text/javascript" src="../tdp/js/validator.js"></script>
    <script type="text/javascript" src="../tdp/js/public.js"></script>
    <script type="text/javascript" src="../javascript/handleArchive.js"></script>
    <script language="JavaScript">
        function doDBClick(url, operator, type) {
            if (operator == false) {
                document.forms[0].action = url + "&op=view";
                document.forms[0].submit();
            } else {
                document.forms[0].action = url;
                document.forms[0].submit();
            }
        }
    </script>
</head>

<body>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
        <tr>
            <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;人力资源--&gt;工人管理</td>
            <td align="right">&nbsp;</td>
        </tr>
    </table>
    <br/>

    <form  method="post" action="${pageContext.request.contextPath}/Homemaking/workersvl?reqType=addWorker" enctype="multipart/form-data">
        <input type="hidden" name="reqType" value="addWorker">
        <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="67%" height="40" align="center" nowrap class="MENU_line1">工人资料登记表</td>
            </tr>
        </table>
        <br>
        <table width="96%" height="577" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3"
               class="text_lb">
            <tr>
                <td width="106" height="23" align="right" bgcolor="#FFFFFF">员工编号：</td>
                <td width="280" bgcolor="#FFFFFF">
                    <input name="worker_number" type="text" id="textarea1" value="" size="30" class="pi">
                </td>
                <td width="116" align="right" bgcolor="#FFFFFF">所属公司：</td>
                <td width="300" bgcolor="#FFFFFF">
                    <input name="company_number" type="text" id="textarea2" value="" size="30" class="pi">
                </td>
                <td width="131" rowspan="8" align="center" valign="middle" bgcolor="#FFFFFF">相片
                    <input type="file" name="photo" value="photo">
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
                <td bgcolor="#FFFFFF">
                    <input name="worker_name" type="text" id="textarea3" value="" size="30" class="pi">
                </td>
                <td align="right" bgcolor="#FFFFFF">性别：</td>
                <td bgcolor="#FFFFFF">
                    <input type="radio" name="gender" id="radio1" value="男">男
                    <input type="radio" name="gender" id="radio2" value="女">女
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
                <td bgcolor="#FFFFFF">
                    <input name="idnumber" type="text" id="textarea4" value="" size="30" class="pi">
                </td>
                <td height="23" align="right" bgcolor="#FFFFFF">出生年月：</td>
                <td bgcolor="#FFFFFF">
                    <input name="birthday" type="text" id="textarea5" value="" size="30" class="pi">
                </td>
            </tr>
            <tr>
                <td align="right" bgcolor="#FFFFFF">年龄：</td>
                <td bgcolor="#FFFFFF">
                    <input name="age" type="text" id="textarea6" value="" size="30" class="pi">
                </td>
                <td height="23" align="right" bgcolor="#FFFFFF">身高：</td>
                <td bgcolor="#FFFFFF">
                    <input name="height" type="text" id="textarea7" value="" size="30" class="pi">
                </td>
            </tr>
            <tr>
                <td align="right" bgcolor="#FFFFFF">手机：</td>
                <td bgcolor="#FFFFFF">
                    <input name="mobile_phone" type="text" id="textarea8" value="" size="30" class="pi">
                </td>
                <td align="right" bgcolor="#FFFFFF">电话：</td>
                <td bgcolor="#FFFFFF">
                    <input name="telephone" type="text" id="textarea9" value="" size="30" class="pi">
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">工种：</td>
                <td bgcolor="#FFFFFF">
                    <input name="work_type" type="text" id="textarea10" value="" size="30" class="pi">
                </td>
                <td align="right" bgcolor="#FFFFFF">从业时间：</td>
                <td bgcolor="#FFFFFF">
                    <input name="work_time" type="text" id="textarea11" value="" size="30" class="pi">
                </td>
            </tr>

            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">缺陷：</td>
                <td bgcolor="#FFFFFF">
                    <input name="disadvantage" type="text" id="textarea12" value="" size="30" class="pi">
                </td>
                <td align="right" bgcolor="#FFFFFF">教育程度：</td>
                <td bgcolor="#FFFFFF">
                    <input type="radio" name="education" id="radio3" value="大专"/>大专&nbsp;
                    <input type="radio" name="education" id="radio4" value="高中"/>高中&nbsp;
                    <input type="radio" name="education" id="radio5" value="初中"/>初中&nbsp;
                    <input type="radio" name="education" id="radio6" value="小学"/>小学&nbsp;
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <input name="idnumber" type="text" id="textarea13" value="" size="30" class="pi"></td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">户籍地址：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <input name="address" type="text" id="textarea14" value="" size="65" class="pi">
                    <span class="text">
                        <input type="submit" name="searchbtn" value="选  择" class="button_new">
                    </span>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">现住地址：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <input name="current_address" type="text" id="textarea15" value="" size="65" class="pi">
                    <span class="text">
                        <input type="submit" name="searchbtn2" value="选  择" class="button_new">
                    </span>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">银行卡号：</td>
                <td bgcolor="#FFFFFF">
                    <input name="bankcard" type="text" id="textarea16" value="" size="30" class="pi">
                </td>
                <td align="right" bgcolor="#FFFFFF">保险单号：</td>
                <td colspan="2" bgcolor="#FFFFFF">
                    <input name="insurance" type="text" id="textarea17" value="" size="30" class="pi">
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">爱好：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <input type="checkbox" name="hobby" id="唱歌"/>唱歌&nbsp;
                    <input type="checkbox" name="hobby" id="舞蹈"/>舞蹈&nbsp;
                    <input type="checkbox" name="hobby" id="乐器"/>乐器&nbsp;
                    <input type="checkbox" name="hobby" id="体育"/>体育&nbsp;
                    <input type="checkbox" name="hobby" id="书法"/>书法&nbsp;
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">语言：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <input type="checkbox" name="language" id="checkbox6" value="普通话"/>普通话&nbsp;
                    <input type="checkbox" name="language" id="checkbox7"value="广州话"/>广州话&nbsp;
                    <input type="checkbox" name="language" id="checkbox8"value="英语"/>英语
                    其它语言：&nbsp;
                    <input name="language" type="text" id="textarea18" value="" size="30" class="pi"></td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">状态：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <input type="radio" name="status" id="radio7" value="在岗"/>在岗&nbsp;&nbsp;
                    <input type="radio" name="status" id="radio8" value="待岗"/>待岗&nbsp;&nbsp;
                    <input type="radio" name="status" id="radio9" value="其它"/>其它：&nbsp;
                    <input name="status" type="text" id="textarea19" value="" size="30" class="pi">
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">婚姻状况：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <input type="radio" name="marital" id="radio10" value="已婚"/>已婚&nbsp;
                    <input type="radio" name="marital" id="radio11" value="未婚"/>未婚&nbsp;&nbsp;
                    <input type="radio" name="marital" id="radio12" value="离异"/>离异&nbsp;
                    <input type="radio" name="marital" id="radio13" value="丧偶"/>丧偶&nbsp;&nbsp;
                    <input type="radio" name="marital" id="radio14" value="其它"/>
                    其它：&nbsp;
                    <input name="marital" type="text" id="textarea20" value="" size="30" class="pi">
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">证照状况：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <input type="license" name="checkbox4" id="计生证"/>计生证&nbsp;
                    <input type="license" name="checkbox4" id="健康证"/>健康证&nbsp;&nbsp;
                    <input type="license" name="checkbox4" id="暂住证"/>暂住证&nbsp;&nbsp;
                    <input type="license" name="checkbox4" id="上岗证"/>上岗证
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">体检情况：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td width="68%" height="28" bgcolor="#FFFFFF">
                                <input type="checkbox" name="check_up" id="肝功"/>肝功&nbsp;
                                <input type="checkbox" name="check_up" id="胸透"/>胸透&nbsp;&nbsp;
                                <input type="checkbox" name="check_up" id="皮肤妇科"/>皮肤妇科
                                &nbsp;&nbsp;&nbsp;&nbsp;其它：&nbsp;
                                <input name="check_up" type="text" id="textarea21" value="" size="30" class="pi">
                            </td>
                            <td width="11%" align="right" bgcolor="#FFFFFF">体检时间：</td>
                            <td width="21%" bgcolor="#FFFFFF">
                                <input name="check_up_time" type="text" id="textarea22" value="" size="16" class="pi">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" nowrap bgcolor="#FFFFFF">家庭成员：
                    <input type="button" name="button3" id="button3" value="+"/>
                </td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">关系</div>
                            </td>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">姓名</div>
                            </td>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">年龄</div>
                            </td>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">电话</div>
                            </td>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">工作单位(学校)</div>
                            </td>
                        </tr>
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="relation" type="text" id="textarea23" value="" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="name" type="text" id="textarea24" value="" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="fam_age" type="text" id="textarea25" value="" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="tele" type="text" id="textarea26" value="" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="school" type="text" id="textarea27" value="" size="18" class="pi">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">个人技能：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="1" cellspacing="0" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td height="28" bgcolor="#FFFFFF">
                                <input type="checkbox" name="skill" id="checkbox16" value="照顾婴儿"/>照顾婴儿 &nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox17" value="带小孩"/>带小孩 &nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox18" value="照顾老人"/>照顾老人 &nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox19" value="煮饭"/>煮饭 &nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox20" value="粤菜"/>粤菜 &nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox21" value="客家菜"/>客家菜 &nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox22" value="煲烫"/>煲烫
                            </td>
                        </tr>
                        <tr>
                            <td height="28" bgcolor="#FFFFFF">
                                <input type="checkbox" name="skill" id="checkbox23" value="扫地"/>扫地 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox24" value="拖地"/>拖地 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox25" value="擦窗"/>擦窗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox26" value="洗衣"/>洗衣 &nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox27" value="打蜡"/>打蜡 &nbsp;&nbsp;&nbsp;
                                <input type="checkbox" name="skill" id="checkbox28" value="通渠"/>通渠&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;其它：
                                <input name="skill" type="text" id="textarea28" value="" size="30" class="pi">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">主要工作经历：
                    <input type="button" name="button4" id="button4" value="+"/>
                </td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td width="45%" height="28" bgcolor="#FFFFFF">
                                <div align="center">单位</div>
                            </td>
                            <td width="17%" height="28" bgcolor="#FFFFFF">
                                <div align="center">工种</div>
                            </td>
                            <td width="17%" height="28" bgcolor="#FFFFFF">
                                <div align="center">职务</div>
                            </td>
                            <td width="21%" height="28" bgcolor="#FFFFFF">
                                <div align="center">工作时间</div>
                            </td>
                        </tr>
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="unit" type="text" id="textarea29" value="" size="40" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="type" type="text" id="textarea30" value="" size="18" class="pi"></td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="position" type="text" id="textarea31" value="" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="hours" type="text" id="textarea32" value="" size="18" class="pi">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">岗位培训记录：
                    <input type="button" name="button5" id="button5" value="+"/></td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td width="42%" height="28" bgcolor="#FFFFFF">
                                <div align="center">培训机构</div>
                            </td>
                            <td width="25%" height="28" bgcolor="#FFFFFF">
                                <div align="center">培训内容</div>
                            </td>
                            <td width="15%" height="28" bgcolor="#FFFFFF">
                                <div align="center">培训情况</div>
                            </td>
                            <td width="18%" height="28" bgcolor="#FFFFFF">
                                <div align="center">培训时间</div>
                            </td>
                        </tr>
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="institution" type="text" id="textarea33" value="" size="40" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="content" type="text" id="textarea34" value="" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="situation" type="text" id="textarea35" value="" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="time" type="text" id="textarea36" value="" size="18" class="pi">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">自我介绍：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <textarea name="introduction" id="textarea37" cols="60" rows="5"></textarea>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">人人要求：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td width="10%" height="28" align="right" bgcolor="#FFFFFF">时间要求：</td>
                            <td width="37%" height="28" bgcolor="#FFFFFF">
                                <input name="req_time" type="text" id="textarea38" value="" size="40" class="pi">
                            </td>
                            <td width="10%" height="28" align="right" bgcolor="#FFFFFF">住宿：</td>
                            <td width="43%" height="28" bgcolor="#FFFFFF">
                                <input name="stay_room" type="text" id="textarea39" value="" size="40" class="pi">
                            </td>
                        </tr>
                        <tr>
                            <td height="28" align="right" bgcolor="#FFFFFF">工资要求：</td>
                            <td height="28" bgcolor="#FFFFFF">
                                <input name="req_pay" type="text" id="textarea40" value="" size="40" class="pi">
                            </td>
                            <td height="28" align="right" bgcolor="#FFFFFF">餐饮或其它：</td>
                            <td height="28" bgcolor="#FFFFFF">
                                <input name="food" type="text" id="textarea41" value="" size="40" class="pi">
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <input type="hidden" name="entry_time"  id="date" onload="getTime()">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <table width="96%" height="104" border="0" align="center" class="text_lb">
            <tr>
                <td width="126" height="23" align="right">个人声明：</td>
                <td width="1146">1、本资料由所属公司提供，本人保证所填资料属实。</td>
            </tr>
            <tr>
                <td height="23">&nbsp;</td>
                <td>2、本人保证从无任何刑事记录。</td>
            </tr>
            <tr>
                <td height="23">&nbsp;</td>
                <td>3、如有虚假或伪造资料，一切责任自负。</td>
            </tr>
            <tr>
                <td height="23">&nbsp;</td>
                <td>4、本人同意将资料公布在96909系统。</td>
            </tr>
        </table>
        <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="67%" align="center" class="text" nowrap>
                    <input type="submit" name="searchbtn3" value="保  存" class="button_new">
                    <input type="submit" name="searchbtn3" value="返  回" class="button_new"
                           onClick="javascript:location.href='grxx.jsp'">
                    <input type="hidden" name="info" value="${info}">
                    &nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </form>
</body>
<script>
    function getTime() {
        var date=new Date();
        var time=date.getFullYear()+"-"+date.getMonth()+1+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
        document.getElementById("date").value=time;
    }
</script>
</html>
