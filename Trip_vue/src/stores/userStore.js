import { ref, computed } from "vue";
import { defineStore } from "pinia";
import {} from "@/api/UserApi.js";
// 라우터 변경 테스트 해보기
const useUserStore = defineStore("useUserStore", () => {
  // //1. state
  // const customers = ref([]);
  // const customer = ref({});
  const loginUser = ref({
    userId: "",
  });

  const login = (user, payload) => {
    user.value = payload;
  };

  const userLogin = async (loginUser) => {
    await userConfirm(
      loginUser,
      (response) => {
        if (response.status === 200) {
          let { data } = response;

          isLogin.value = true;
          isLoginError.value = false;
          isValidToken.value = true;
          sessionStorage.setItem("accessToken", accessToken);
          sessionStorage.setItem("refreshToken", refreshToken);
        } else {
          console.log("로그인 실패했다");
          isLogin.value = false;
          isLoginError.value = true;
          isValidToken.value = false;
        }
      },
      (error) => {
        console.error(error);
      }
    );
  };

  // //2. action
  // const allCustomer = () => {
  //   selectAll(
  //     (res) => {
  //       customers.value = res.data;
  //     },
  //     (e) => {
  //       console.log(e);
  //     }
  //   );
  // };
  // //3. getter
  // const all = computed(() => customers.value);
  // const one = computed(() => customer.value);

  return {
    userConfirm,
  };
});

export { useUserStore };
