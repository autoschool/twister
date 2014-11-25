<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#macro layout title="Twister">
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
                <div class="col-md-offset-1 col-md-4">
                    <h1>
                        <a href="/">
                            <span class="text-primary">T</span><span class="text-warning">W</span><span class="text-success">I</span><span class="text-danger">S</span><span class="text-primary">T</span><span class="text-warning">E</span><span class="text-success">R</span>
                        </a>
                    </h1>
                <div class="clearfix">
                    <#if model.authUser?? >
                         <div class="pull-left">
                            <a href="/post/new" class="btn btn-warning">New post</a>
                         </div>
                        <div class="pull-right">
                            <a href="/profile" class="btn btn-primary">Profile</a>
                            <a href="/auth/signout" class="btn btn-danger">Sign out</a>
                        </div>


                    <#else >

                        <div class="pull-left">
                            <a href="/auth/signin" class="btn btn-success">Sign in</a>
                            <a href="/auth/register" class="btn btn-success">Register</a>
                        </div>

                    </#if>
                </div>
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