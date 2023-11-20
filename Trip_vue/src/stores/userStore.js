import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { loginConfirm, regist, changePw, deleteAccount } from "@/api/UserApi.js";
// 라우터 변경 테스트 해보기
const useUserStore = defineStore("useUserStore", () => {
  const session = ref({
    uid: "",
    id: "",
    nickname: "",
    admin: false,
  });
  const isLogin = ref(false);
  const login = (id, pw) => {
    loginConfirm(
      id,
      pw,
      (res) => {
        if (res.data) {
          isLogin.value = true;
          session;
        }
      },
      (err) => {
        console.log(err);
      }
    );
  };
  const logout = () => {};

  const user = computed(() => session.value);
  return {
    login,
    logout,
    user,
    isLogin,
  };
});

export { useUserStore };
