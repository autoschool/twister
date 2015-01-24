<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<#import "../partials/post/body.ftl" as postBody />
<#import "../partials/comment/body.ftl" as commentBody />
<@layout.layout title="${model.post.title} - Twister">
<div class="row">
<div class="col-md-12">
    <div class="panel panel-default">
        <@postBody.postTemplate post=model.post isPreview=false />

        <div class="panel-footer">
            <a name="comments">
                <h5>Comments (${model.post.comments?size})</h5>
            </a>

            <ul class="list-group">
                <#list model.post.comments as comment>
                    <@commentBody.commentTemplate comment=comment />
                </#list>
            </ul>

            <a name="lastComment"></a>

            <#if model.authUser?? >
                <form class="form" role="form" action="/post/${model.post.id}/addComment" method="post">
                    <div class="styled-input wide">
                        <textarea rows="3" name="commentBody" required></textarea>
                        <label>Comment body</label>
                        <span></span>
                    </div>
                    <button type="submit" class="btn btn-default">Add Comment</button>
                </form>
            <#else >
                <div class="alert alert-warning" role="alert">
                    Only authorised user can comment. Please, <a class="alert-link" href="/auth/signin" >sign in</a>.
                </div>
            </#if>
        </div>
    </div>
</@layout.layout>
