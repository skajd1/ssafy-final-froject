<script setup>
import { reactive, ref, watch } from "vue";

const user = reactive({
  nickname: "",
  userid: "",
  password: "",
  passwordCheck: "",
});

const errorid = ref(false);
const errorid2 = ref(false);
const errorpwd = ref(false);

watch(
  () => user.userid,
  (userid) => {
    checkidlen(userid);
  }
);

watch(
  () => user.passwordCheck,
  (pwdcheck) => {
    checkPwdRetry(pwdcheck);
  }
);

const checkidlen = (userid) => {
  const idCheck = /^[a-zA-Z가-힣0-9]{4,12}$/;

  if (idCheck.test(userid)) {
    errorid.value = false;
  } else {
    errorid.value = true;
  }
};

const checkPwdRetry = (pwdcheck) => {
  if (user.password !== pwdcheck) {
    errorpwd.value = true;
  } else {
    errorpwd.value = false;
  }
};

const userJoin = () => {};
</script>

<template>
  <div class="container">
    <form>
      <div>
        <label for="nickname" class="form-label">닉네임 : </label>
        <input
          type="text"
          class="form-control"
          id="nickname"
          placeholder="이름"
          v-model="user.nickname"
        />
      </div>
      <div>
        <label for="userid" class="form-label">아이디 : </label>
        <input
          type="text"
          class="form-control"
          id="userid"
          placeholder="아이디"
          v-model="user.userid"
        />
        <!-- <div class="success-message" v-show="sucessid">사용할 수 있는 아이디입니다</div> -->
        <div class="failure-message" v-show="errorid">아이디는 4~12글자이어야 합니다</div>
        <div class="failure-message2" v-show="errorid2">영어 또는 숫자만 가능합니다</div>
      </div>
      <div>
        <label for="pwd" class="form-label">비밀번호 : </label>
        <input
          type="password"
          class="form-control"
          id="pwd"
          placeholder="비밀번호"
          v-model="user.password"
        />
        <!-- <div class="strongPassword-message hide">8글자 이상, 영문, 숫자, 특수문자(@$!%*#?&)를 사용하세요</div> -->
      </div>
      <div>
        <label for="pwdcheck" class="form-label">비밀번호 확인 : </label>
        <input
          type="password"
          class="form-control"
          id="pwdcheck"
          placeholder="비밀번호확인"
          v-model="user.passwordCheck"
        />
        <div class="mismatch-message" v-show="errorpwd">비밀번호가 일치하지 않습니다</div>
      </div>

      <div class="col-auto text-center">
        <button type="button" class="btn btn-outline-primary mb-3" @click="userJoin">
          회원가입
        </button>
        <button type="button" class="btn btn-outline-success ms-1 mb-3">초기화</button>
      </div>
    </form>
  </div>
</template>

<style lang="scss" scoped>
.container {
  color: var(--main-color);
  display: flex;
  justify-content: center;
  width: 1000px;

  form {
    width: 100%;
  }

  div {
    margin-bottom: 1rem;

    button {
      margin: 10px;
    }
  }
}
</style>
