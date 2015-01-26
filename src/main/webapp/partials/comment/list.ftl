<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#macro commentListTemplate comments inPost >
<#import "body.ftl" as commentBody />
<ul class="list-group">
    <#list comments as comment>
        <@commentBody.commentTemplate comment=comment inPost=inPost />
    </#list>
</ul>
</#macro>