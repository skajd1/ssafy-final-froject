<script setup>
import { useRouter } from "vue-router";
import Search from "@/components/common/Search.vue";
import { useTripStore } from "@/stores/tripStore";
import { storeToRefs } from "pinia";
const store = useTripStore();
const { keyword: keyword } = storeToRefs(store);
const router = useRouter();
const search = () => {
  if (keyword.value === "") {
    alert("검색어를 입력해주세요");
    return;
  }
  router.push("/search" + "?keyword=" + keyword.value);
};
</script>

<template>
  <div id="container">
    <div id="title">
      <h1>어디로 가냥?<img src="@/assets/logo1.svg" /></h1>
    </div>
    <div id="SearchBar">
      <Search></Search>
      <button @click="search">검색</button>
    </div>
  </div>
</template>

<style scoped>
h1 {
  font-size: 100px;
  text-align: center;
  color: var(--main-color);
}
#container {
  padding-top: 10rem;
  background-color: var(--vt-c-bg);
  height: 100vh;
}
#SearchBar {
  width: 60%;
  display: flex;

  align-items: center;
  margin: 0 auto;
}
button {
  margin-top: 2rem;
  width: 100px;
  height: 50px;
  font-size: 30px;
  border: 1px solid var(--main-color);
  border-radius: 10px;
  outline-color: var(--main-color);

  text-align: center;
  color: var(--main-color);
  margin-left: 1rem;
}
</style>
