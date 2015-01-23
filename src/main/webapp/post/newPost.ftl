<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="New post - Twister">
<div class="row">
    <div class="col-md-12">
        <form class="form" role="form" action="/post/new" method="post">
            <div class="page-header">
                <div class="form-group">
                    <input type="text" class="form-control" id="title" name="title"
                           placeholder="Post Title">
                </div>
            </div>
            <div class="form-group">
                <textarea class="form-control" rows="10" name="body"></textarea>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-danger pull-right" id="publish">Publish</button>
                </div>
            </div>
        </form>
    </div>
</div>
</@layout.layout>