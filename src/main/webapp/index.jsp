<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSRF-DSC-Login</title>
        <script src="jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <%@include file='header.jsp'%>
    </head>
    <body>
        <br>
        <div class="container">
            <div class="form-group"> 
                <h1>CSRF-Synch Token Pattern</h1>
            </div>
            <form id="loginForm" action="POST">
                <div class="form-group">    
                    <input class="form-control" type="text" id="username" name="username" placeholder="Username"/>
                </div>
                <div class="form-group">  
                    <input class="form-control" type="password" id="password" name="password" placeholder="Password"/>
                </div>
                <button class="btn btn-primary mb-2">Login</button>
            </form>
        </div>
        
        <script>
            $('#loginForm').submit((e)=>{
               var url = './Login';
               
               console.log('Submitting Add user form');
                              
               $.ajax({
                type: "POST",
                url: url,
                data: $("#loginForm").serialize(), // serializes the form's elements.
                success: function(data)
                {
                    window.location.assign("./");
                },
                error: function(err){
                    alert(err);
                }
              });
              
              e.preventDefault();
               
            });
        </script>
    </body>    
</html>