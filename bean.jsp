<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Résultat JavaBean</title></head>
<body>
    <jsp:useBean id="person" class="isep.lab1.bean.Person" scope="request" />
    <jsp:setProperty name="person" property="*" />

    <h1>Données reçues via le Bean :</h1>
    <ul>
        <li>Prénom : <jsp:getProperty name="person" property="firstName" /></li>
        <li>Nom : <jsp:getProperty name="person" property="lastName" /></li>
        <li>Date de naissance : <jsp:getProperty name="person" property="birthDay" /></li>
        <li>Sexe : <jsp:getProperty name="person" property="sex" /></li>
    </ul>
</body>
</html>