<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Twister.${model.profile.name}" >

    <div class="row">
        <div class="col-xs-3">
            Name
        </div>
        <div class="col-xs-9">
            ${model.profile.name}
        </div>
    </div>
    <div class="row">
        <div class="col-xs-3">
            With Twister since
        </div>
        <div class="col-xs-9">
            ${model.profile.createdAt}
        </div>
    </div>

</@layout.layout>
