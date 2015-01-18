<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Twister">
<div class="row">
<div class="col-md-12">
    <div class="page-header">
        <h1>${model.post.title}</h1>

        <div class="signature">
            <a href="/user/${model.post.userId}">
                <i class="glyphicon glyphicon-user"></i>
                ${model.post.user.name}
            </a>

            <b class="divider-slash"></b>

            <span>
                <i class="glyphicon glyphicon-time"></i>
                ${model.post.createdAt}
            </span>

            <b class="divider-slash"></b>

            <span>
                <#if model.authUser?? && model.post.user == model.authUser>
                    <form role="form" action="/post/${model.post.id}/edit" method="get" style="display: inline-block;">
                        <a href="#" onclick="this.parentNode.submit()">
                            <span class="glyphicon glyphicon-pencil"></span>
                            edit
                        </a>
                    </form>

                    <b class="divider-slash"></b>

                    <form role="form" action="/post/${model.post.id}/remove" method="post" style="display: inline-block;">
                        <a href="#" onclick="this.parentNode.submit()">
                            <span class="glyphicon glyphicon-remove"></span>
                            remove
                        </a>
                    </form>
                </#if>
            </span>
        </div>

    </div>
    <div class="post-body">
        ${model.post.body}
    </div>

    <div class="comments">
        <a name="comments">
            <h3>Comments (${model.post.comments?size})</h3>
        </a>

        <ul class="list-group">
            <#list model.post.comments as comment>

                <li class="list-group-item">
                    <div class="signature">
                        <a href="/user/${comment.userId}">
                            <i class="glyphicon glyphicon-user"></i>
                        ${comment.user.name}
                        </a>

                        <b class="divider-slash"></b>

                        <span>
                            <i class="glyphicon glyphicon-time"></i>
                            ${comment.createdAt}
                        </span>

                    </div>
                    <div class="well-sm">
                        ${comment.body}
                    </div>
                </li>

            </#list>
        </ul>

        <#if model.authUser?? >
            <form class="form" role="form" action="/post/${model.post.id}/addComment" method="post">
                <div class="form-group">
                    <textarea class="form-control" rows="3" name="commentBody"></textarea>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Add Comment</button>
                    </div>
                </div>
            </form>
        <#else >
            <div class="alert alert-warning" role="alert">
                Only authorised user can comment. Please, <a class="alert-link" href="/auth/signin" >sign in</a>.
            </div>
        </#if>
    </div>
</@layout.layout>
