<%@page import="com.lxisoft.model.Contact,java.util.*"%>

<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
	<title></title>
</head>
<body>
    
	    <div id="login">
        <h3 class="text-center text-white pt-5">Delete Contact</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" modelAttribute="contact" action="DeleteContactServlet" method="GET">
                            <h3 class="text-center text-info">Delete Contact</h3>
                            <div class="form-group">
                                <label for="name" class="text-info">Name</label><br>
                        <input type="text" name="name" id="name" class="form-control" value="<%= request.getParameter("temp")%>">
                        <input type="hidden" name="id" id="id" class="form-control" value="<%= request.getParameter("id")%>">

                            </div>

                            <div class="form-group">
                                               
                                <!--input type="submit" style="text-indent:-9999px"-->   
                                <script type="text/javascript">
                                        document.getElementById("login-form").submit(); 

                                </script>   
                                                      </div>
                          
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>