<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../../layouts/main.ftl" as layout />
<@layout.layout title="Too long name">

<div class="row">
    <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
        <div class="alert alert-error" role="alert">
            You entered too long name. Please, try to decreases number of used symbols to 50.
            <a href="/profile" class="btn btn-primary"  >
                Return to profile
            </a>
        </div>
    </div>
</div>
</@layout.layout>
