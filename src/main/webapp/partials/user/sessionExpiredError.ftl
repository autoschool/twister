<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../../layouts/main.ftl" as layout />
<@layout.layout title="Session expired">

<div class="row">
    <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
        <div class="alert alert-warning" role="alert">
            Your session has been expired.
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".register-modal" >
                Relogin
            </button>
        </div>
    </div>
</div>
</@layout.layout>
