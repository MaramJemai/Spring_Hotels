<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Modifier un Hotel</title>
</head>
<body>
<div class="container mt-5">
<div class="card-body">
<form action="updateHotel" method="post">
 <div class="form-group">
 <label class="control-label">ID Hotel :</label>
 <input type="number" name="id" value="${hotel.id}" readonly class="form-control"/>
 </div>
 <div class="form-group">
 <label class="control-label">Nom Hotel :</label>
 <input type="text" name="nom" value="${hotel.nom}" class="form-control"/>
 </div>
 <div class="form-group">
 <label class="control-label">Adresse Hotel :</label>
 <input type="text" name="adresse" value="${hotel.adresse}" class="form-control"/>
 </div>
 <div class="form-group">
    <label class="control-label">Etoile Hotel :</label>
    <input type="number" name="etoile" value="${hotel.etoile}" class="form-control"/>
</div>
<div class="form-group">
    <label class="control-label">Contact Hotel :</label>
    <input type="number" name="contact" value="${hotel.contact}" class="form-control"/>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
<br/>
<br/>
<a href="ListeHotels">Liste Hotels</a>
</div>
</body>
</html>