<#-- @ftlvariable name="comment" type="ru.qatools.school.twister.models.Comment" -->
<#macro commentTemplate comment>
<li class="list-group-item">
    <div class="signature">
        <a href="/user/${comment.userId}" name="comment-${comment.longId}">
            <i class="fa fa-user"></i>
            ${comment.user.name?html}
        </a>

        <b class="divider-slash"></b>

        <span>
            <i class="fa fa-clock-o"></i>
            ${comment.createdAt}
        </span>
    </div>
    <div class="commentBody">
        ${comment.body?html}
    </div>
</li>
</#macro>