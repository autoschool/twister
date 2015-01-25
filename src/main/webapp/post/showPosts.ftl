<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<#import "../partials/post/list.ftl" as postList />
<@layout.layout title="Twister">
<div class="row">
    <div class="col-xs-12 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8 ">
        <@postList.postListTemplate />
    </div>
</div>
</@layout.layout>
