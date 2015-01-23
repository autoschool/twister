<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<#import "../partials/post/body.ftl" as postBody />
<#import "../partials/comments/comment.ftl" as commentBody />
<@layout.layout title="${model.post.title} - Twister">
<div class="row">
<div class="col-md-12">
    <div class="page-header">
        <@postBody.postTemplate post=model.post isPreview=false />
    </div>

    <div class="comments">
        <a name="comments">
            <h3>Comments (${model.post.comments?size})</h3>
        </a>

        <ul class="list-group">
            <#list model.post.comments as comment>
                <@commentBody.commentTemplate comment=comment />
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
        <a name="lastComment"></a>
    </div>
</@layout.layout>
