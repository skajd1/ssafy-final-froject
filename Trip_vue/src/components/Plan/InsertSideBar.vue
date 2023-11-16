<script setup>
import VueAwesomeSideBar from "vue-awesome-sidebar";
import "vue-awesome-sidebar/dist/vue-awesome-sidebar.css";

import { ref } from "vue";

const collapsed = ref(false);
const miniMenu = ref(false);
</script>

<template>
  <div>
    <VueAwesomeSideBar
      v-model:miniMenu="miniMenu"
      v-model:collapsed="collapsed"
      :menu="testMenu"
      width="200px"
    ></VueAwesomeSideBar>
  </div>
</template>

<style scoped></style>
