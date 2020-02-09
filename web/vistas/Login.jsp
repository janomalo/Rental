<!DOCTYPE html>

<html lang="en"> <head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <title>Java Web Intro</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
      <div  class="container mb-4 col-4">
    <form class="form-signin" action="Controlador" method="post">
      <img class="mb-4" src="style/bootstrap-solid.html" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Por favor Inicie sesión</h1>
      <label for="inputUser" class="sr-only">Usuario</label>
      <input id="inputUser" name="user" class="form-control" placeholder="User" required="" autofocus="" type="text">
      <label for="inputPassword" class="sr-only">Password</label>
      <input id="inputPassword" name="password" class="form-control" placeholder="Password" required="" type="password">
      <input class="btn btn-lg btn-primary btn-block" type="submit"  name="accion" value="Ingresar">
      <p class="mt-5 mb-3 text-muted">© 2019</p>
    </form>
   </div>

</body>


</html>