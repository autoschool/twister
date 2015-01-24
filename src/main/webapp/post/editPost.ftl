<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<#import "../partials/post/form.ftl" as postForm />

<@layout.layout title="Edit post - Twister">
<#if model.authUser?? && model.post.user == model.authUser>
    <div class="panel panel-default">
        <@postForm.postFormTemplate action="/post/edit" />
    </div>
<#elseif model.authUser?? >
    <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
        <div class="alert alert-warning" role="alert">
            You can edit only your own posts.
    </div>
<#else >
    <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
        <div class="alert alert-warning" role="alert">
            You can edit only your own posts.<br/>
            But if you sure that this one really yours, please
            <a href="#" data-toggle="modal" data-target=".signin-modal" >sign in</a>.
        </div>
    </div>
</#if>
</@layout.layout>