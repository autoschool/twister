<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#macro layout title="Twister">
<html>
<head>
    <script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

    <link href="/public/app/css/bootstrap-paper.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <script src="/public/app/js/scroller.js" type="text/javascript"></script>
    <link rel="icon" href="/public/app/img/twister.png" />

    <link href="/public/app/css/styles.css" type="text/css" rel="stylesheet"/>
    <link href="/public/app/css/twister.css" type="text/css" rel="stylesheet"/>

    <title>${title}</title>
</head>
<body>
<header class="navbar navbar-default navbar-fixed-top">

    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#main-menu" id="menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="/" id="logo">
                    <span class="twister-title hidden-xs">
                        <span>T</span><span>W</span><span>I</span><span>S</span><span>T</span><span>E</span><span>R</span>
                    </span>
                    <img class="twister-title hidden-sm hidden-md hidden-lg" src="/public/app/img/twister.png" width="48" height="48" />
                </a>
            </div>

            <!-- Collect the nav links, elements, and other content for toggling -->
            <div class="collapse navbar-collapse" id="main-menu" >
                <ul class="nav navbar-nav">
                    <#if model.authUser?? >
                        <li>
                            <a id="post-create" href="/post/new">New post</a>
                        </li>
                    </#if>
                </ul>
                <ul class="nav navbar-nav navbar-right" >
                    <#if model.authUser?? >
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               id="user-menu" aria-expanded="false">
                                    ${model.authUser.login?html}
                                <span class="fa fa-user"></span>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a id="user-profile" href="/profile">Profile</a></li>
                                <li><a id="user-signout" href="/auth/signout">Sign out</a></li>
                            </ul>
                        </li>
                    <#else >
                        <li>
                            <a href="#" id="register-button" data-toggle="modal" data-target=".register-modal" >Register</a>
                        </li>
                        <li>
                            <a href="#" id="signin-button" data-toggle="modal" data-target=".signin-modal" >Sign in</a>
                        </li>
                    </#if>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</header>

<div class="container">
    <#nested />
    <#include "/partials/login/modal.ftl">
    <#include "/partials/register/modal.ftl">
</div>
</body>
</#macro>