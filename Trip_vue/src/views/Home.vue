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
  margin: 0 auto;
}
</style>
