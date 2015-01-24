<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<#import "../partials/post/body.ftl" as postBody />
<@layout.layout title="Twister">
<div class="row">
    <div class="col-xs-12">
        <#list model.posts as post>
            <div class="panel panel-default">
                <div class="panel-body">

                    <@postBody.postTemplate post=post isPreview=true />

                    <a href="/post/${post.id}" class="btn btn-default">Read more</a>

                </div>
            </div>
        </#list>
    </div>
</div>
</@layout.layout>
