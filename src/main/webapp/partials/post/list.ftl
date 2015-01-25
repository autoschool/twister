<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#macro postListTemplate >
<#import "body.ftl" as postBody />

<#list model.posts as post>
    <div class="post panel panel-default">
        <@postBody.postTemplate post=post isPreview=true />
        <div class="panel-footer">
            <a href="/post/${post.id}" class="btn btn-default">Read more</a>
        </div>
    </div>
</#list>

</#macro>