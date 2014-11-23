<#-- @ftlvariable name="model" type="ru.qatools.school.twister.models.User" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Twister.${model.name}" >

    <div class="row">
        <div class="col-xs-3">
            Name
        </div>
        <div class="col-xs-9">
            ${model.name}
        </div>
    </div>
    <div class="row">
        <div class="col-xs-3">
            With Twister since
        </div>
        <div class="col-xs-9">
            ${model.createdAt}
        </div>
    </div>

</@layout.layout>
