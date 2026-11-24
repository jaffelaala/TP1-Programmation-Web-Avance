<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Personne âgée</title></head>
<body>
    <h1>Résultat (Né avant 1990)</h1>

    <jsp:useBean id="person" type="lab.mvc.model.Person" scope="request" />
    
    <ul>
        <li>Prénom : <jsp:getProperty name="person" property="firstName" /></li>
        <li>Nom : <jsp:getProperty name="person" property="lastName" /></li>
        <li>Date de naissance : <jsp:getProperty name="person" property="birthDay" /></li>
        <li>Sexe : <jsp:getProperty name="person" property="sex" /></li>
    </ul>
</body>
</html>