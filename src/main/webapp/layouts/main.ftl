<#macro layout title="Switter">
<html>
<head>
    <script src="/public/jquery/js/jquery.min.js" type="text/javascript"></script>
    <link href="/public/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="/public/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <link href="/public/app/css/styles.css" type="text/css" rel="stylesheet"/>
    <link href="/public/app/css/twister.css" type="text/css" rel="stylesheet"/>

    <title>${title}</title>
</head>
<body style="padding-top: 191px">
<header class="navbar navbar-default navbar-fixed-top">


<div id="masthead">
  <div class="container">
    <div class="row">
      <div class ="col-md-1">
      </div>
      <div class="col-md-4">
        <H1><a href="/post/all"><span class="text-primary">T</span><span class="text-warning">W</span><span class="text-success">I</span></span><span class="text-danger">S</span><span class="text-primary">T</span><span class="text-warning">E</span><span class="text-success">R</span></a> </H1>
        <div class="clearfix">

            <div class="pull-left"><a href="/auth/signin" class="btn btn-success">Sign in</a>
            <a href="/auth/signon" class="btn btn-success">Sign on</a></div>
            <div class="pull-right"><a href="/profile" class="btn btn-primary">Profile</a>
            <a href="/auth/signout" class="btn btn-danger">Sign out</a></div>
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