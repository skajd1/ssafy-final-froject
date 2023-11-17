<script setup>
import { RouterLink } from "vue-router";
defineProps({
  item: Object,
});
</script>

<template>
  <div>
    <RouterLink :to="{ name: 'MyListDetail', params: { pid: item.pid } }">
      <div>{{ item.title }}</div>
    </RouterLink>
  </div>
</template>

<style scoped></style>
