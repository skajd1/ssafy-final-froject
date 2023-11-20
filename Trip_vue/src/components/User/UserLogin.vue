<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/userStore";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";
const router = useRouter();
const store = useUserStore();

const { isLogin, userInfo } = storeToRefs(store);
const { login, getUserInfo } = store;

const loginUser = ref({
  userId: "",
  userPwd: "",
});
function userLogin() {
  login(loginUser.value.userId, loginUser.value.userPwd);

  if (isLogin) {
    getUserInfo(loginUser.value.userId);
    console.log(userInfo.value);
    router.push("/main");
  }
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center"><spane>로그인</spane></h2>
      </div>
      <div class="col-lg-10">
        <form>
          <div class="mb-3 text-start">
            <label for="userid" class="form-label">아이디 : </label>
            <input
              type="text"
              class="form-control"
              v-model="loginUser.userId"
              placeholder="아이디"
            />
          </div>
          <div class="mb-3 text-start">
            <label for="userpwd" class="form-label">비밀번호 : </label>
            <input
              type="password"
              class="form-control"
              v-model="loginUser.userPwd"
              @keyup.enter="userLogin"
              placeholder="비밀번호"
            />
          </div>
          <div id="remember" class="form-check mb-3 float-end">
            <input class="form-check-input" type="checkbox" id="saveid" />
            <label class="form-check-label" for="saveid"> 아이디저장 </label>
          </div>
          <div class="col-auto text-center">
            <button type="button" class="btn btn-outline-primary mb-3" @click="userLogin">
              로그인
            </button>
            <button type="button" class="btn btn-outline-success ms-1 mb-3">회원가입</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.container {
  color: var(--main-color);
}

#remember {
  margin-top: 1rem;

  input {
    margin-right: 0.5rem;
  }
}
</style>
