<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Twister">
<div class="row">
<div class="col-md-12">
    <div class="page-header">
        <h2>${model.post.title}</h2>
    </div>
    <div class="post-body">
    ${model.post.body}

        <div>
            <a href="/user/${model.post.userId}">
            <span class="glyphicon glyphicon-user"></span>
            <span>${model.post.user.name}</span>
                </a>
        </div>
        <div>
            <span class="glyphicon glyphicon-time"></span>
            <span>${model.post.createdAt}</span>
        </div>
        <div>
            <a href="/post/${model.post.id}/edit">
                <span class="glyphicon glyphicon-pencil"></span>
                edit
            </a>
        </div>
        <div class="panel-body">
            <ul class="list-group">
                <#list model.post.comments as comment>

                    <li class="list-group-item">${comment.body}</li>

                </#list>
            </ul>

        <#if model.authUser?? >
            <form class="form" role="form" action="/post/${model.post.id}/addComment" method="post">
                <div class="form-group">
                    <textarea class="form-control" rows="3" name="commentBody"></textarea>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default pull-right">Add Comment</button>
                    </div>
                </div>
            </form>
        <#else >
            <div class="alert alert-warning" role="alert">
                Only authorised user can comment. Please, <a class="alert-link" href="/auth/signin" >sign in</a>.
            </div>
        </#if>
            <div>
            </div>
        </div>
    </div>
</@layout.layout>
