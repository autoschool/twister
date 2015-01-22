<form class="form" role="form" action="/auth/register" method="post">
    <div class="modal-body">
        <div class="form-group">
            <label for="name">Introduce yourself</label>
            <input type="text" class="form-control" id="register-name" name="register-name"
                   placeholder="Please, enter your real name">
        </div>
        <div class="form-group" id="register-login-box">
            <label for="login">Login</label>
            <input type="text" class="form-control" id="register-login" name="register-login"
                   placeholder="Login">
        </div>
        <div class="form-group">
            <label for="pass">Password</label>
            <input type="password" class="form-control" id="register-pass" name="register-pass"
                   placeholder="Password">
        </div>
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-danger pull-right" id="register-submit">Register</button>
    </div>
</form>