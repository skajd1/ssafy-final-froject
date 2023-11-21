<script setup>
import { useUserStore } from "@/stores/userStore";
import { storeToRefs } from "pinia";
import { RouterLink } from "vue-router";
import { useRouter } from "vue-router";
const store = useUserStore();
const router = useRouter();
const { isLogin, userInfo } = storeToRefs(store);
// console.log(userInfo.value);

const logout = () => {
  store.logout();
  alert("로그아웃 되었습니다.");
  router.push({ name: "Home" });
};
</script>

<template>
  <div>
    <div v-if="isLogin == false" class="user">
      <RouterLink :to="{ name: 'Login' }"
        ><input class="btn" type="button" value="로그인"
      /></RouterLink>
      <RouterLink :to="{ name: 'Join' }"
        ><input class="btn" type="button" value="회원가입"
      /></RouterLink>
    </div>
    <div v-else><input type="button" class="btn" value="로그아웃" @click="logout()" /></div>
  </div>
</template>

<style lang="scss" scoped>
.user {
  display: flex;
  justify-content: flex-end;
  margin-right: 10px;
}

.btn {
  background-color: transparent;

  &:focus {
    border: none;
    outline: none;
    background-color: transparent;
  }

  &:hover {
    background-color: transparent;
  }
}
</style>
