<%-- 
    Document   : header
    Created on : Jul 24, 2018, 6:16:48 PM
    Author     : aaralk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <script>
            $(document).ready(() => {
                if (isLoggedIn()) {
                    $('#btnLogin').hide();
                    $('#btnLogout').show();
                } else {
                    $('#btnLogin').show();
                    $('#btnLogout').hide();
                }
            });


            function logout() {
                console.log('Clearing cookies');
                deleteAllCookies();
            }
            function deleteAllCookies() {
                var cookies = document.cookie.split(";");
                for (var i = 0; i < cookies.length; i++) {
                    var cookie = cookies[i];
                    var eqPos = cookie.indexOf("=");
                    var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
                    document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
                }
            }
            function isLoggedIn() {
                var cookies = document.cookie.split(";");
                for (var i = 0; i < cookies.length; i++) {
                    var cookie = cookies[i];
                    var eqPos = cookie.indexOf("=");
                    var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
                    if (name == "SESSIONID") {
                        return true;
                    }
                }
                return false;
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand" href="">CSRF-STP</a>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="./adduser.jsp">Add User<span class="sr-only">(current)</span></a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                <button id="btnLogout" class="btn btn-danger" onclick="logout()">Logout</button>
                <a id="btnLogin" class="btn btn-success" href='./';'>Login</a>
            </form>
        </nav>
    </body>
</html>
