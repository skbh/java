<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>getLinView.jsp</title>
</head>
<body>
<div style="background-color:gray; font-family: sans-serif; color:white; " align="center">
${HeaderMesageSSDS}
</div>
<br>
<div style="background-color: silver; font-family: sans-serif; color:navy; ">
<form method="post" action="/SSDSClientV2.0/get">
<fieldset><legend>Know your Lin</legend>
            <center>
            <table border="0" width="40%" cellpadding="2">
                     <tbody>
                    <tr>
                        <td>Enter Reference Number</td>
                        <td><input type="text" name="referenceNumber"  placeholder="Enter Reference Number"/ required></td>
                    </tr>
                    <tr>
                        <td>Enter office Acronym</td>
                        <td><input type="text" name="officeAcronym" placeholder="Enter office Acronym" required /></td>
                    </tr>
                    <tr>
                        <td>Enter Reference Date</td>
                        <td><input type="date" name="referenceDate" placeholder="Enter Reference Date" required /></td>
                    </tr>
                    
                    <tr>
                        <td>Enter Identifier Acronym</td>
                        <td><input type="text" name="identifierAcronym" placeholder="Enter Identifier Acronym"  required/></td>
                    </tr>
                    
                    <tr>
                        <td>Enter Identifier</td>
                        <td><input type="text" name="identifier" placeholder="Enter Identifier" required /></td>
                    </tr>
                    
                                  
                    <tr>
                        <td>Enter userId</td>
                        <td><input type="text" name="userId" placeholder="Enter userId"  required/></td>
                    </tr>
                    <tr>
                        <td>Enter userPassword</td>
                        <td><input type="password" name="userPassword" placeholder="Enter userPassword" required/></td>
                    </tr>
                    <tr>
                        <td></td>
                        
                        <td><input type="submit" value="KnowYourLin" />
                        <input type="reset" value="Reset" /></td>
                    </tr>
                    
                </tbody>
            </table>
            </center>
            </fieldset>
        </form>
     </div>
     <br>
     <div style="background-color:gray; font-family: sans-serif; color:white; font-size: x-small; " align="center" >
Information : Welcome to Unified Portal for Registration of Units for LIN, Reporting of Inspection, Submission of returns & Grievance Redressal...<br>
***The employers who are registered with EPFO and have been using the online return portal ECR Portal of EPFO find the code number as Establishment ID on the right hand top corner of the portal after login.
</div>
   
</body>
</html>


