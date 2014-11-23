<#-- @ftlvariable name="model" type="ru.qatools.school.switter.models.User" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Registration finish">

   <div class="row">
       <div class="col-md-3">
            <p>Пользователь успешно создан</p>
            ${model.name}
       </div>
   </div>

</@layout.layout>