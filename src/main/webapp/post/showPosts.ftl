<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<#import "../partials/post/body.ftl" as postBody />
<@layout.layout title="Twister">
<div class="row">
    <div class="col-xs-12 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8 ">
        <#list model.posts as post>
            <div class="post panel panel-default">
                <@postBody.postTemplate post=post isPreview=true />
                <div class="panel-footer">
                    <a href="/post/${post.id}" class="btn btn-default">Read more</a>
                </div>
            </div>
        </#list>
    </div>
</div>
</@layout.layout>
