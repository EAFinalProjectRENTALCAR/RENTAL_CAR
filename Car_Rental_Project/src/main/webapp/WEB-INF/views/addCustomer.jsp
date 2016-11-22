<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Book</title>
    </head>
    <body>
       <form:form modelAttribute="newCustomer" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />

            <table width="100%" border="0">
				  <tr>
				    <td><strong>Personal Information</strong></td>
				    <td>&nbsp;</td>
				  </tr>
				  <tr>
				    <td width="294">First Name: *</td>
				    <td width="530">
				      <form:input id="personalDetail.firstName" type="text" path="personalDetail.firstName" />				  
				    </td>
				    <td><form:errors path="personalDetail.firstName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>Middle Name: *</td>
				    <td>
				      <form:input id="personalDetail.middleName" type="text" path="personalDetail.middleName" />		
				    </td>
				    <td><form:errors path="personalDetail.middleName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>Last Name: *</td>
				    <td>
				      <form:input id="personalDetail.lastName" type="text" path="personalDetail.lastName" />		
				    </td>
				    <td><form:errors path="personalDetail.lastName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>Date Of Birth: *</td>
				    <td><label><span id="spryselect1">Year
				          <select name="cbBirthYear" id="cbBirthYear">
				            <option value="1984">1984</option>
				          </select></span> <span id="spryselect2">Month
				      <select name="cbBirthMonth" id="cbBirthMonth">
				        <option value="1">1</option>
				      </select></span><span id="spryselect3">Date
				      <select name="cbBirthDate" id="cbBirthDate">
				        <option value="1">1</option>
				      </select></span></label></td>
				      <td><form:errors path="personalDetail.firstName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>Title: *</td>
				    <td><span id="spryselect4">
				      <label>
				      <select name="cbTitle" id="cbTitle">
				      </select>
				      </label></span></td>
				      <td><form:errors path="personalDetail.firstName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>Customer Email: *</td>
				    <td>
				      <form:input id="personalDetail.customerEmail" type="text" path="personalDetail.customerEmail" />		
				    </td>
				    <td><form:errors path="personalDetail.customerEmail" cssClass="error" /> </td>
				  </tr>
				   <tr>
				    <td>Customer Phone: *</td>
				    <td>
				      <form:input id="personalDetail.customerPhone" type="text" path="personalDetail.customerPhone" />		
				    </td>
				    <td><form:errors path="personalDetail.customerPhone" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>User Name: *</td>
				    <td>
				      <form:input id="username" type="text" path="username" />		
				    </td>
				    <td><form:errors path="username" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>Password: *</td>
				    <td>
				      <form:input id="password" type="password" path="password" />		
				    </td>
				    <td><form:errors path="password" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>Drivers License Number:*</td>
				    <td>
				      <form:input id="personalDetail.driverLicenceNumber" type="text" path="personalDetail.driverLicenceNumber" />		
				    </td>
				    <td><form:errors path="personalDetail.driverLicenceNumber" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>Driver Licence Using Country Or State: *</td>
				    <td><span id="spryselect5">
				      <label>
				      <select name="cbDriverLicenceUsingCountryOrState" id="cbDriverLicenceUsingCountryOrState">
				        <option value="United State - Alaska">United State - Alaska</option>
				      </select>
				      </label></span></td>
				      <td><form:errors path="personalDetail.firstName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				   <td>Driver License Expiration Date: *</td>
				    <td><label>
				    	<span id="spryselect1">Year
				          <select name="cbBirthYear" id="cbBirthYear">
				          </select>
				          </span> 
				          <span id="spryselect2">Month
				      		<select name="cbBirthMonth" id="cbBirthMonth">
				     		 </select>
				     	  </span>
				     	  <span id="spryselect3">Date
				     		 <select name="cbBirthDate" id="cbBirthDate">
				      		</select>
				      	  </span>
				      	  </label>
				     </td>
				     <td><form:errors path="personalDetail.firstName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  <tr>
				    <td><strong>Billing Address</strong></td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  <tr>
				    <td>Address: *</td>
				    <td>
				      <form:input id="billingAddress.streetName" type="text" path="billingAddress.streetName" />		
				    </td>
				    <td><form:errors path="billingAddress.streetName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>City: *</td>
				    <td>
				      <form:input id="billingAddress.city" type="text" path="billingAddress.city" />		
				    </td>
				    <td><form:errors path="billingAddress.city" cssClass="error" /> </td>
				  </tr>
				  
				  <tr>
				    <td>Zip Code: *</td>
				    <td>
				      <form:input id="billingAddress.zipCode" type="text" path="billingAddress.zipCode" />		
				    </td>
				    <td><form:errors path="billingAddress.zipCode" cssClass="error" /> </td>
				  </tr>
				  
				  <tr>
				    <td>Country: *</td>
				    <td><select name="cbCountry" id="cbCountry">
				      <option value="United State - Alaska">United State - Alaska</option>
				    </select></td>
				    <td><form:errors path="personalDetail.firstName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  <tr>
				    <td><strong>Credit Card</strong></td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  
				  <tr>
				    <td>Credit Card Type: *</td>
				    <td><span id="spryselect6">
				      <label>
				      <select name="cbCreditCardType" id="cbCreditCardType">
				        <option value="AirPlus">AirPlus</option>
				        <option value="Visa">Visa</option>
				      </select>
				      </label></span></td>
				       <td><form:errors path="personalDetail.firstName" cssClass="error" /> </td>
				  </tr>
				  <%-- <tr>
				    <td>Credit Card Number: *</td>
				    <td>
				      <form:input id="creditCard.creditCardNumber" type="text" path="creditCard.creditCardNumber" />		
				    </td>
				    <td><form:errors path="creditCard.creditCardNumber" cssClass="error" /> </td>
				  </tr> --%>
				  <tr>
				    <td>Credit Card Expiration Date: *</td>
				    <td><label><span id="spryselect7">Year
				      <select name="cbCreditCardExpirationYear" id="CreditCardExpirationYear">
				      </select></span> <span id="spryselect8">Month
				              <select name="cbCreditCardExpirationMonth" id="cbCreditCardExpirationMonth">
				            </select>
				            <span id="spryselect9">Date
				              <select name="cbCreditCardExpirationDate" id="cbCreditCardExpirationDate">
				            </select></span></label></td>
				      <td><form:errors path="personalDetail.firstName" cssClass="error" /> </td>
				  </tr>
				  <tr>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  
				  <tr>
				    <td>&nbsp;</td>
				    <td><input type="submit" name="btnbutton" id="btnbutton" value="Submit" />
				    <td>&nbsp;</td>
				  </tr>
				  <tr>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				</table>
           <!--  <input type="submit"/> -->

        </form:form>
    </body>
</html>