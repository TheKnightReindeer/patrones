<%-- 
    Document   : altaCita
    Created on : May 21, 2017, 9:42:19 PM
    Author     : maldad
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar cita</h1>
    <center>
        <table with="50%">
            <form action="BuscarPaciente" method="post"/>
            <tr>
                <td colspan="2">Datos de la cita</td>
            </tr>
            <tr>
                <td>Hora:</td>
                <td><input type="time" placeholder="hh:mm am/pm" name="horaCita"></td>
            </tr>
            <tr>
                <td>Fecha:</td>
                <td><input type="date" placeholder="d/M/yyyy" name="fechaCita"></td>
            </tr>
            
            <tr>
                <td>Paciente: </td>
                <td><input type="submit" value="Buscar paciente"></td>
            </tr>
    </center>
    </body>
</html>
