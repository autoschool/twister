<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#-- @ftlvariable name="post" type="ru.qatools.school.twister.models.Post" -->
<#macro postTemplate post isPreview=false >
<h1>
    <#if isPreview>
        <a href="/post/${post.id}">${post.title?html}</a>
    <#else>
        ${post.title?html}
    </#if>
</h1>

<div class="signature">
    <a href="/user/${post.userId}">
        <i class="glyphicon glyphicon-user"></i>
        ${post.user.login?html}
    </a>

    <b class="divider-slash"></b>

    <span>
        <i class="glyphicon glyphicon-time"></i>
        ${post.createdAt}
    </span>

    <#if model.authUser?? && post.user == model.authUser>
        <span>
            <b class="divider-slash"></b>

            <form role="form" action="/post/${post.id}/edit" method="get" style="display: inline-block;">
                <a href="#" onclick="this.parentNode.submit()">
                    <span class="glyphicon glyphicon-pencil"></span>
                    edit
                </a>
            </form>

            <b class="divider-slash"></b>

            <form role="form" action="/post/${post.id}/remove" method="post" style="display: inline-block;">
                <a href="#" onclick="this.parentNode.submit()">
                    <span class="glyphicon glyphicon-remove"></span>
                    remove
                </a>
            </form>
        </span>
    </#if>
</div>

<div class="${isPreview?string('post-body--short','post-body')}">
    ${post.body?html}
</div>
</#macro>