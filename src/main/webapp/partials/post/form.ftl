<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#macro postFormTemplate action >
<#assign isNew=action?contains("new") />

<form class="form" role="form" action="${action}" method="post">
    <#if model.post.id?? >
        <input type="hidden" value="${model.post.id}" name="id">
    </#if>

    <div class="panel-heading">
        <div class="styled-input wide">
            <input type="text" id="title" name="title" value="${model.post.title}" required >
            <label>Title</label>
            <span></span>
        </div>
    </div>

    <div class="panel-body">
        <div class="styled-input wide">
            <textarea name="body" ${isNew?string("","style='height:50%'")} required>${model.post.body}</textarea>
            <label>Post body</label>
            <span></span>
        </div>
    </div>

    <div class="panel-footer">
        <button type="submit" class="btn btn-primary" id="${isNew?string("publish","save")}"">${isNew?string("Publish","Save")}</button>
    </div>
</form>
</#macro>