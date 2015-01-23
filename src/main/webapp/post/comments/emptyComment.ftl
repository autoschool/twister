<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Empty comment">

<div class="row">

    <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
        <div class="alert alert-danger" role="alert">
            Comment cannot be empty. Please, <a class="alert-link" href="/post/${model.post.id}#lastComment" >try to send more meaningful</a> :).
        </div>
    </div>
</div>

</@layout.layout>