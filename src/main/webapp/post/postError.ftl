<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Posting error">

<div class="row">
    <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
        <div class="alert alert-warning" role="alert">
            Post should have
            <ol>
                <li>Not empty title with no more than 100 characters.</li>
                <li>Not empty body.</li>
            </ol>
            Just 2 rules. Sure you can do it. <a class="alert-link" href="/post/new">Good luck</a>! ;)
        </div>
    </div>
</div>

</@layout.layout>