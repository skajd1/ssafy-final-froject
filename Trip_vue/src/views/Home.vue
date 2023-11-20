<script setup>
import Search from "@/components/common/Search.vue";
</script>

<template>
  <div id="container">
    <div id="title">
      <h1>어디로 가냥?<img src="@/assets/logo1.svg" /></h1>
    </div>
    <div id="SearchBar">
      <Search></Search>
      <button>검색</button>
    </div>
  </div>
</template>

<style scoped>
h1 {
  font-size: 100px;
  text-align: center;
  margin-top: 2rem;
  color: var(--main-color);
}
#container {
  background-color: var(--vt-c-bg);
  height: 85vh;
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
