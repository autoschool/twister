<#-- @ftlvariable name="model" type="ru.qatools.school.twister.models.User" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Registration finish">

   <div class="row">
       <div class="col-md-3">
            <p>Пользователь <b>${model.name}</b> успешно создан</p>
       </div>
   </div>

</@layout.layout>