<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/userStore";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";
const router = useRouter();
const store = useUserStore();

const { isLogin } = storeToRefs(store);
const { login, getUserInfo } = store;

const loginUser = ref({
  userId: "",
  userPwd: "",
});

const userLogin = async () => {
  if (loginUser.value.userId === "" || loginUser.value.userPwd === "") {
    // alert("아이디와 비밀번호를 입력해주세요.");
    return;
  }

  await login(loginUser.value.userId, loginUser.value.userPwd);

  console.log("isLogin: ", isLogin.value);

  if (isLogin.value) {
    getUserInfo(loginUser.value.userId);
    router.push("/main");
  } else {
    alert("아이디와 비밀번호를 확인해주세요.");
  }
};
</script>

<template>
  <div class="container">
    <form>
      <div class="bar">
        <label for="userid" class="form-label">아이디 : </label>
        <input type="text" class="form-control" v-model="loginUser.userId" placeholder="아이디" />
      </div>
      <div>
        <label for="userpwd" class="form-label">비밀번호 : </label>
        <input
          type="password"
          class="form-control"
          v-model="loginUser.userPwd"
          @keyup.enter="userLogin"
          placeholder="비밀번호"
        />
      </div>
      <!-- <div id="remember" class="form-check mb-3 float-end">
            <input class="form-check-input" type="checkbox" id="saveid" />
            <label class="form-check-label" for="saveid"> 아이디저장 </label>
          </div> -->
      <div class="col-auto text-center">
        <button type="button" @click="userLogin">로그인</button>
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

    div {
      margin: 5px;
      margin-bottom: 10px;
    }
  }
}
/*
#remember {
  margin-top: 1rem;

  input {
    margin-right: 0.5rem;
  }
} */

button {
  margin-top: 30px;
  background-color: var(--main-color);
  color: white;
  font-size: 20px;
  border: none;
  border-radius: 10px;
  padding: 5px 10px;

  &:hover {
    background-color: var(--main-color);
    color: var(--main-color-bg);
  }

  &:active {
    background-color: var(--main-color);
    color: var(--main-color-bg);
  }

  &:focus {
    border: none;
    outline: none;
  }
}
</style>
