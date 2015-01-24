<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../../layouts/main.ftl" as layout />
<@layout.layout title="Login error">

<div class="row">

    <div class="col-md-offset-4 col-md-4">
        <div class="alert alert-danger" role="alert">
            Wrong user name or password.
            Please,
                <a class="alert-link" href="#" data-toggle="modal" data-target=".signin-modal" >
                    try again
                </a>.
        </div>
    </div>
</div>

</@layout.layout>