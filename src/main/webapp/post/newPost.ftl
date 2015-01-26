<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<#import "../partials/post/form.ftl" as postForm />

<@layout.layout title="New post - Twister">
<#if model.authUser?? >
    <div class="panel panel-default">
        <@postForm.postFormTemplate action="/post/new" />
    </div>
<#else>
    <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
        <div class="alert alert-warning" role="alert">
            Only authorised user can make posts. Please,
            <a href="#" id="signin-button" class="alert-link"
               data-toggle="modal" data-target=".signin-modal" >sign in</a>.
        </div>
    </div>
</#if>
</@layout.layout>