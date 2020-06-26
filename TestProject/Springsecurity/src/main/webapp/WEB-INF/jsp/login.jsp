<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" href="login.css">
  <script defer src="login-page.js"></script>
</head>

<body>
  <main id="main-holder">
    <center><h1 id="login-header">MOCKEXAM</h1></center>
    
    <div id="login-error-msg-holder">
     
    </div>
    
    <form id="login-form">
     <center> <input type="text" name="username" id="username-field" class="login-form-field" placeholder="Username"><br><br>
      <input type="password" name="password" id="password-field" class="login-form-field" placeholder="Password">
      <input type="submit" value="Login" id="login-form-submit">
    </form>
  </center>
  </main>
</body>

</html>
