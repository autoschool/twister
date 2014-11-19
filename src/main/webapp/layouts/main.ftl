<#macro layout title="Switter">
<html>
<head>
    <script src="/public/jquery/js/jquery.min.js" type="text/javascript"></script>
    <link href="/public/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="/public/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <link href="/public/app/css/styles.css" type="text/css" rel="stylesheet"/>

    <title>${title}</title>
</head>
<body style="padding-top: 191px">
<header class="navbar navbar-default navbar-fixed-top">


<div id="masthead">
  <div class="container">
    <div class="row">
      <div class ="col-md-1">
      </div>
      <div class="col-md-5">
        <H1><a href="/post/all">TWISTER</a> </H1>
        <div>

            <a href="/auth/signin" class="btn btn-default">Sign in</a>
            <a href="/auth/signon" class="btn btn-default">Sign on</a>
            <a href="/profile" class="btn btn-default">Profile</a>
            <a href="/auth/signout" class="btn btn-default">Sign out</a>
            </div>
      </div>
      <div class="col-md-2">

                          </div>

    </div>
  </div>
</header>




<div class="content">
    <div class="container">
        <#nested />
    </div>
</div>
</body>
</#macro>